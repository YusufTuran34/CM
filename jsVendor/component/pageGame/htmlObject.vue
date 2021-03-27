<template>
  <div class="active-show-border">
    <span @click="$emit('click-item', {element : elements, order: 'first'})" v-if="readyForAddElement != null">
      Ekle
    </span>
    <span @click="$emit('remove-item', elements)" v-if="readyForAddElement == null && readyToDelete == true">
      Sil
    </span>
    <div v-for="element in elements">
      <div v-if="element.el == 'div'" :class="element.class">
        <html-object v-if="element.subElement != null"
                     :elements="element.subElement"
                     @click-item="$emit('click-item', $event)"
                     @src-change="$emit('src-change', $event)"
                     @remove-item="$emit('remove-item', $event)"
                     @text-change="$emit('text-change', $event)"></html-object>
      </div>
      <img @dblclick="$emit('src-change', element)"
         v-if="element.el == 'img'" :src="element.src">
      <label @dblclick="$emit('text-change', element)"
             v-if="element.el == 'label'  && element.text != null"> {{ element.text }} </label>
      <p @dblclick="$emit('text-change', element)"
         v-if="element.el == 'p'      && element.text != null"> {{ element.text }} </p>
      <legend @dblclick="$emit('text-change', element)"
              v-if="element.el == 'legend' && element.html != null" v-html="element.html"></legend>

      <slider-component v-if="element.el == 'slider'" :slider="element.slider"></slider-component>
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
import recentPost from "../general/recentPost";
import sliderComponent from "../general/sliderComponent";
import { slider, slideritem } from 'vue-concise-slider';
import BultenComponent from "../general/bultenComponent";
import BreadCrumbComponent from "../general/breadCrumbComponent";
export default {
  name: "htmlObject",
  components : {BreadCrumbComponent, BultenComponent, sliderComponent,slider,slideritem,recentPost},
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
    }
  },
}
</script>

<style scoped>

</style>