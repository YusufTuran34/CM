package com.helpers;

import com.model.*;
import org.bson.Document;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class DocumentHelper {

    public Document seoToDocument(Seo seo){
        Document document = new Document();
        if(seo != null){
            document.append("title",seo.getTitle());
            document.append("description",seo.getDescription());
            document.append("keywords",seo.getKeywords());
            document.append("ogtitle",seo.getOgtitle());
            document.append("ogdescription",seo.getOgdescription());
            document.append("ogtype",seo.getOgtype());
            document.append("ogsite_name",seo.getOgsite_name());
            document.append("ogimage",seo.getOgimage());
            document.append("ogurl",seo.getOgurl());
            document.append("yandexVerification",seo.getYandexVerification());
            document.append("msvalidate01",seo.getMsvalidate01());
            document.append("canonical",seo.getCanonical());
        }
        return document;
    }

    public Document socialMediaToDocument(SocialMedia socialMedia){
        Document document = new Document();
        if(socialMedia != null){
            document.append("facebookUrl",socialMedia.getFacebookUrl());
            document.append("twitterUrl",socialMedia.getTwitterUrl());
            document.append("pinterestUrl",socialMedia.getPinterestUrl());
            document.append("youtubeUrl",socialMedia.getYoutubeUrl());
            document.append("linkedinUrl",socialMedia.getLinkedinUrl());
        }
        return document;
    }

    public Document settingsToDocument(Settings settings){
        Document document = new Document();
        if(settings != null){
            document.append("logo",imgToDocument(settings.getLogo()));
            document.append("favIcon",imgToDocument(settings.getFavIcon()));
            document.append("analyticsId",settings.getAnalyticsId());
            document.append("tagManagerId",settings.getTagManagerId());
            document.append("seo",seoToDocument(settings.getSeo()));
            document.append("socialMedia",socialMediaToDocument(settings.getSocialMedia()));
        }
        return document;
    }

    public Document imgToDocument(Img img){
        Document document = new Document();
        if(img != null){
            document.append("url",img.getUrl());
            document.append("title",img.getTitle());
        }
        return document;
    }

    public Document userToDocument(User user){
        Document document = new Document();
        if(document != null){
            document.append("id",user.getId());
            document.append("name",user.getName());
            document.append("lastname",user.getLastname());
        }
        return document;
    }

    public Document contentToDocument(Content content){
        Document document = new Document();
        if(document != null){
            document.append("html_desktop",content.getHtml_desktop());
            document.append("html_mini",content.getHtml_mini());
        }
        return document;
    }

    public Document blogToDocument(Blog blog){
        Document document = new Document();
        if(document != null){
            document.append("id",blog.getId());
            document.append("title",blog.getTitle());
            document.append("subTitle",blog.getSubTitle());
            document.append("date",blog.getDate());
            document.append("owner",userToDocument(blog.getOwner()));
            document.append("url",blog.getUrl());
            document.append("banner",imgToDocument(blog.getBanner()));
            document.append("content",contentToDocument(blog.getContent()));
            document.append("seo",seoToDocument(blog.getSeo()));
        }
        return document;
    }

    public Document pageToDocument(Page page){
        Document document = new Document();
        if(document != null){
            document.append("id",page.getId());
            document.append("title",page.getTitle());
            document.append("url",page.getUrl());
            document.append("seo",seoToDocument(page.getSeo()));
            document.append("blogList",blogListToDocumentList(page.getBlogList()));
            document.append("content",contentToDocument(page.getContent()));
            document.append("banner",imgToDocument(page.getBanner()));
        }
        return document;
    }

    public List<Document> blogListToDocumentList(List<Blog> blogList){
        List<Document> documentList = new LinkedList<>();

        if(blogList != null) {
            for (int i = 0; i < blogList.size(); i++) {
                documentList.add(blogToDocument(blogList.get(i)));
            }
        }

        return documentList;
    }

    public Document navbarItemToDocument(NavbarItem navbarItem){
        Document document = new Document();
        if(document != null){
            document.append("id",navbarItem.getId());
            document.append("url",navbarItem.getUrl());
            document.append("name",navbarItem.getName());
        }
        return document;
    }
}
