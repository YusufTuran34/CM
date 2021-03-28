<template>
  <div class="section layout_padding">
    <div class="container">
      <div v-for="(blog,index) in blogList" class="row margin_top_30">
          <div class="col-md-6" v-if="index%2 == 0" >
            <div class="full blog_cont">
              <h4>{{blog.title}}</h4>
<!--              <h5>MAY 19 2019  5 READ</h5>-->
              <p>{{blog.content.html_mini}}</p>
              <a :href="'/'+pageUrl+'/'+blog.url">Daha Fazla</a>
            </div>
          </div>
          <div class="col-md-6" v-if="index%2 == 0" >
            <img :src="blog.banner.url" :alt="blog.banner.title" />
          </div>

          <div class="col-md-6" v-if="index%2 == 1" >
            <img :src="blog.banner.url" :alt="blog.banner.title" />
          </div>
          <div class="col-md-6" v-if="index%2 == 1" >
            <div class="full blog_cont">
              <h4>{{blog.title}}</h4>
              <!--              <h5>MAY 19 2019  5 READ</h5>-->
              <div v-html="blog.content.html_mini"></div>
              <a :href="'/'+pageUrl+'/'+blog.url">Daha Fazla</a>
            </div>
          </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "blogPostListComponent",
  props : ['blogList','pageUrl']
}
</script>

<style scoped>

</style>