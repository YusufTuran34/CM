<template>
  <div style="height: 700px">
    <div class="banner-slider" @dblclick="$emit('slider-change',slider)">
    <div class="container-fluid">
      <div class="row">
        <div class="col-md-7">
          <div id="slider_main" class="carousel slide" data-ride="carousel">
            <!-- The slideshow -->
            <div class="carousel-inner">
              <div class="carousel-item active">
                <img  alt="#" :src="slider.imageList[0]"/>
              </div>
              <div class="carousel-item" v-for="(sld,index) in slider.imageList">
                <img  v-if="index > 0" alt="#" :src="sld"/>
              </div>

            </div>
            <!-- Left and right controls -->
            <a class="carousel-control-prev" href="#slider_main" data-slide="prev">
              <i class="fa fa-angle-left" aria-hidden="true"></i>
            </a>
            <a class="carousel-control-next" href="#slider_main" data-slide="next">
              <i class="fa fa-angle-right" aria-hidden="true"></i>
            </a>

          </div>
        </div>
        <div class="col-md-5">
          <div class="full slider_cont_section">
            <h4>More Featured in</h4>
            <h3>Jack Blogger</h3>
            <p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look</p>
            <div class="button_section">
              <a href="about.html">Read More</a>
              <a href="contact.html">Contact Us</a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  </div>
</template>

<script>
import AddImage from "../tools/addImage";
export default {
  name: "carouselComponent",
  components: {AddImage},
  props:{
    preview:false,
    slider:null,
  },
  data:function (){
    return {
      selectedImage: null,
      components :[AddImage]
    }
  },
  methods:{
    onChangeFirst(e) {
      const file = e.target.files[0];
      this.selectedImage = URL.createObjectURL(file);
    },
    add(){
      this.components.push(AddImage);
    }
  }
}
</script>

<style scoped>

</style>
