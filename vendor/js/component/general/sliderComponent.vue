<template>
  <div style="width:100%;margin:20px auto;height:400px">
    <slider ref="slider" :options="slider.options">
      <slideritem v-for="(item,index) in slider.someList" :key="index" :style="item.style">{{item.html}}</slideritem>
      <div slot="loading">loading...</div>
    </slider>
  </div>
</template>

<script>
import { slider, slideritem } from 'vue-concise-slider';
export default {
  name: "sliderComponent",
  components : {slider,slideritem},
  props: {
    slider:Object,
  }
}
</script>

<style scoped>

</style>