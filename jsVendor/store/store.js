import Vue from 'vue'
import Vuex from 'vuex'
import generalFunction from "../generalFunction";
Vue.use(Vuex)

export const store = new Vuex.Store({
  state: {
    users: null,
    navbars : null,
    settings : null,
    pages : null,
  },
  mutations: {
    getUsers (state,users) {
      state.users = users;
    },
    getNavbars(state,navbars){
      state.navbars = navbars;
    },
    getSettings(state,settings){
      state.settings = settings;
    },
    getPages(state,pages){
      state.pages = pages;
    },


  },
  actions: {
    getUsers(context) {
      let thatContext = context;
      generalFunction.performGet(null,"http://localhost:9020/admin/user",function (response){
        thatContext.commit('getUsers', response)
      })
    },
    getNavbars(context) {
      let thatContext = context;
      generalFunction.performGet(null,"http://localhost:9020/admin/navbar",function (response){
        thatContext.commit('getNavbars', response)
      })
    },
    getPages(context) {
      let thatContext = context;
      generalFunction.performGet(null,"http://localhost:9020/admin/pages",function (response){
        thatContext.commit('getPages', response)
      })
    },
    getSettings(context) {
      let thatContext = context;
      generalFunction.performGet(null,"http://localhost:9020/admin/settings",function (response){
        thatContext.commit('getSettings', response)
      })
    },

    setSettings(context,settings){
      let thatSettings = settings;
      let thatContext = context;
      generalFunction.performPost(settings,"http://localhost:9020/settings/",function (response){
        thatContext.commit('getSettings', thatSettings)
      })
    },
    addNavbars(context,navbar){
      let thatNavbar = navbar;
      let thatContext = context;
      generalFunction.performPut(navbar,"http://localhost:9020/header/",function (response){
        thatContext.commit('getSettings', thatSettings)
      })
    }
  },
  getters: {
    getUsers: state => {
      return state.users
    },
    getNavbars: state => {
      return state.navbars
    },
    getSettings: state => {
      return state.settings
    },
    getPages: state => {
      return state.pages
    }
  }
})
