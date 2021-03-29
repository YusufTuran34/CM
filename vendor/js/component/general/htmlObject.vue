<template>
  <div class="active-show-border">
    <span @click="$emit('click-item', {element : elements, order: 'first'})" v-if="readyForAddElement != null">
      Ekle
    </span>
    <span @click="$emit('remove-item', elements)" v-if="readyForAddElement == null && readyToDelete == true">
      Sil
    </span>
    <div v-for="element in elements">
      <div v-if="element.el == 'div'" :style="element.css" :class="element.class">
        <div @click="$emit('css-change', element)" v-if="readyForAddElement == null && readyToCss == true">
          Edit CSS
        </div>
        <html-object v-if="element.subElement != null"
                     :elements="element.subElement"
                     @click-item="$emit('click-item', $event)"
                     @css-change="$emit('css-change', $event)"
                     @src-change="$emit('src-change', $event)"
                     @remove-item="$emit('remove-item', $event)"
                     @text-change="$emit('text-change', $event)"
                     @slider-change ="$emit('slider-change',$event)"></html-object>
      </div>
      <img @dblclick="$emit('src-change', element)"
         v-if="element.el == 'img'" :src="element.src" :style="element.css">
      <label @dblclick="$emit('text-change', element)" :style="element.css"
             v-if="element.el == 'label'  && element.text != null"> {{ element.text }} </label>
      <p @dblclick="$emit('text-change', element)" :style="element.css"
         v-if="element.el == 'p'      && element.text != null"> {{ element.text }} </p>
      <legend @dblclick="$emit('text-change', element)" :style="element.css"
              v-if="element.el == 'legend' && element.html != null" v-html="element.html"></legend>

      <carousel-component v-if="element.el == 'slider'" :slider="element.slider" :preview="false" @slider-change ="$emit('slider-change',$event)"></carousel-component>
      <blog-post-list-component v-if="element.el == 'blogList'" :blog-list="element.blogList" :page-url="element.pageUrl"></blog-post-list-component>
      <recent-post v-if="element.el == 'recentpost'" :recent-post-list="element.blogList"></recent-post>
      <bulten-component v-if="element.el == 'bulten'"></bulten-component>
      <bread-crumb-component v-if="element.el == 'breadCrumb'" :bread-crumb-page-list="element.urlList"></bread-crumb-component>

    </div>
    <span @click="$emit('click-item', {element : elements, order: 'last'})" v-if="readyForAddElement != null">
      Ekle
    </span>
  </div>
</template>
<script>
import recentPost from "./recentPost";
import sliderComponent from "./sliderComponent";
import { slider, slideritem } from 'vue-concise-slider';
import BultenComponent from "./bultenComponent";
import BreadCrumbComponent from "./breadCrumbComponent";
import CarouselComponent from "../ui/carouselComponent";
import BlogPostListComponent from "../ui/blog/blogPostListComponent";
export default {
  name: "htmlObject",
  components : {
    BlogPostListComponent,
    CarouselComponent, BreadCrumbComponent, BultenComponent, sliderComponent,slider,slideritem,recentPost},
  data:function (){
    return {

    }
  },
  props:{
    elements : Array
  },
  methods:{

  },
  computed: {
    readyForAddElement(){
      return this.$store.state.element
    },
    readyToDelete(){
      return this.$store.state.readyToDelete
    },
    readyToCss(){
      return this.$store.state.readyToCss
    }
  },
}
</script>

<style scoped>

</style>
