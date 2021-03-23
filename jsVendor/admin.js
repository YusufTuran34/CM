import Vue from 'vue';
import Router from "vue-router";
import {store} from './store/store.js'
import headerComponent from "./component/headerComponent";
import usersComponent from "./component/usersComponent";
import dashboardComponent from "./component/dashboardComponent";
import navbarItemsComponent from "./component/navbarItemsComponent";
import settingsComponent from "./component/settingsComponent";

Vue.use(Router)

const router = new Router({
    routes: [
        {
            path: '/',
            component: dashboardComponent
        },
        {
            path: '/user',
            component: usersComponent
        },
        {
            path: '/navbar',
            component: navbarItemsComponent
        },
        {
            path: '/settings',
            component: settingsComponent
        },
    ]
})

new Vue({
    el: '#admin',
    router : router,
    store,
    components : {headerComponent,usersComponent,dashboardComponent},
    created() {
        this.$store.dispatch('getUsers')
        this.$store.dispatch('getNavbars')
        this.$store.dispatch('getSettings')
        this.$store.dispatch('getPages')
    },
});