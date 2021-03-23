package com.helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.*;
import com.mongodb.BasicDBObject;
import com.mongodb.client.*;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static com.mongodb.client.model.Filters.eq;

@Component
public class MongoDBHelpers {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    DocumentHelper documentHelper;

    @Value("${mongodb.databaseUrl}")
    private String serviceEndpoint;

    @Value("${mongodb.database}")
    private String databaseName;

    private Random random = new Random();

    private MongoDatabase getDatabase(){
        MongoClient mongoClient = MongoClients.create(serviceEndpoint);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        return database;
    }


//    Page
    public boolean createPage(Page page){
        MongoDatabase database = getDatabase();
        MongoCollection<Document> collection = database.getCollection("pages");

        Document document = documentHelper.pageToDocument(page);
        document.append("id", random.nextInt());

        collection.insertOne(document);
        return true;
    }

    public boolean updatePage(Page page){
        MongoDatabase database = getDatabase();
        MongoCollection<Document> collection = database.getCollection("pages");
        Document document = documentHelper.pageToDocument(page);

        collection.replaceOne(
                eq("id", page.getId()),
                document);
        return true;
    }

    public Page getPage(String url) throws JsonProcessingException {
        MongoDatabase database = getDatabase();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        MongoCollection<Document> databaseCollection = database.getCollection("pages");
        FindIterable<Document> iterDoc = databaseCollection.find();
        Iterator it = iterDoc.iterator();
        while (it.hasNext()) {
            Document document = (Document) it.next();
            Page page = objectMapper.readValue(document.toJson(), Page.class);
            if(page.getUrl().equals(url)){
                return page;
            }
        }
        return null;
    }

    public List<Page> getPages() throws JsonProcessingException {
        List<Page> pageList = new LinkedList<>();
        MongoDatabase database = getDatabase();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        MongoCollection<Document> databaseCollection = database.getCollection("pages");
        FindIterable<Document> iterDoc = databaseCollection.find();
        Iterator it = iterDoc.iterator();
        while (it.hasNext()) {
            Document document = (Document) it.next();
            Page page = objectMapper.readValue(document.toJson(), Page.class);
            pageList.add(page);
        }

        return pageList;
    }


//    Settings
    public boolean createSettings(Settings settings){
        MongoDatabase database = getDatabase();
        MongoCollection<Document> collection = database.getCollection("settings");
        Document document = documentHelper.settingsToDocument(settings);
        document.append("id", 0);
        collection.insertOne(document);
        return true;
    }

    public boolean updateSettings(Settings settings){
        MongoDatabase database = getDatabase();
        MongoCollection<Document> collection = database.getCollection("settings");
        Document document = documentHelper.settingsToDocument(settings);
        document.append("id", 0);
        collection.replaceOne(
                eq("id", 0),
                document);
        return true;
    }

    public Settings getSettings() throws JsonProcessingException {
        MongoDatabase database = getDatabase();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        MongoCollection<Document> databaseCollection = database.getCollection("settings");
        BasicDBObject query = new BasicDBObject("id", 0);
        Document object = databaseCollection.find(query).first();
        Settings settings = objectMapper.readValue(object.toJson(),Settings.class);
        return settings;
    }


//    Header
    public List<NavbarItem> getNavbarItem() throws JsonProcessingException {
        List<NavbarItem> navbarItemList = new LinkedList<>();
        MongoDatabase database = getDatabase();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        MongoCollection<Document> databaseCollection = database.getCollection("navbar");
        FindIterable<Document> iterDoc = databaseCollection.find();
        Iterator it = iterDoc.iterator();
        while (it.hasNext()) {
            Document document = (Document) it.next();
            NavbarItem navbarItem = objectMapper.readValue(document.toJson(), NavbarItem.class);
            navbarItemList.add(navbarItem);
        }

        return navbarItemList;
    }

    public boolean updateNavbar(NavbarItem navbarItem){
        MongoDatabase database = getDatabase();
        MongoCollection<Document> collection = database.getCollection("navbar");
        Document document = documentHelper.navbarItemToDocument(navbarItem);

        collection.replaceOne(
                eq("id", navbarItem.getId()),
                document);
        return true;
    }

    public boolean createNavbar(NavbarItem navbarItem){
        MongoDatabase database = getDatabase();
        MongoCollection<Document> collection = database.getCollection("navbar");
        Document document = documentHelper.navbarItemToDocument(navbarItem);
        document.append("id", random.nextInt());
        collection.insertOne(document);
        return true;
    }


//    Blog
    public boolean createBlog(Blog blog,String categoryUrl){
        try {
            Page page = getPage(categoryUrl);
            List<Blog> blogList = page.getBlogList();
            if(blogList == null){
                blogList = new LinkedList<>();
            }
            blog.setId(random.nextInt());
            blogList.add(blog);
            updatePage(page);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean updateBlog(Blog blog,String categoryUrl){
        try {
            Page page = getPage(categoryUrl);
            List<Blog> blogList = page.getBlogList();
            for(int i=0;i<blogList.size();i++){
                if(blogList.get(i).getId() == blog.getId()){
                    blogList.set(i,blog);
                }
            }
            updatePage(page);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return true;
    }

    public Blog getBlog(String blogUrl,String categoryUrl){
        try {
            Page page = getPage(categoryUrl);
            List<Blog> blogList = page.getBlogList();
            for(int i=0;i<blogList.size();i++){
                if(blogList.get(i).getUrl().equals(blogUrl)){
                    return blogList.get(i);
                }
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }


//    User
    public boolean createUser(User user){
        MongoDatabase database = getDatabase();
        MongoCollection<Document> collection = database.getCollection("user");
    
        Document document = documentHelper.userToDocument(user);
        document.append("id", random.nextInt());
    
        collection.insertOne(document);
        return true;
    }

    public boolean updateUser(User user){
        MongoDatabase database = getDatabase();
        MongoCollection<Document> collection = database.getCollection("user");
        Document document = documentHelper.userToDocument(user);

        collection.replaceOne(
                eq("id", user.getId()),
                document);
        return true;
    }

    public User getUser(int id) throws JsonProcessingException {
        MongoDatabase database = getDatabase();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        MongoCollection<Document> databaseCollection = database.getCollection("user");
        BasicDBObject query = new BasicDBObject("id", id);
        Document object = databaseCollection.find(query).first();
        User user = objectMapper.readValue(object.toJson(),User.class);
        return user;
    }

    public List<User> getUsers() throws JsonProcessingException {
        List<User> userList = new LinkedList<>();
        MongoDatabase database = getDatabase();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        MongoCollection<Document> databaseCollection = database.getCollection("user");
        FindIterable<Document> iterDoc = databaseCollection.find();
        Iterator it = iterDoc.iterator();
        while (it.hasNext()) {
            Document document = (Document) it.next();
            User user = objectMapper.readValue(document.toJson(), User.class);
            userList.add(user);
        }

        return userList;
    }
}
