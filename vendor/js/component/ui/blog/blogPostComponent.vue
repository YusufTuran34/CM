<template>
  <div class="section layout_padding blog_blue_bg light_silver">
    <div class="container">
      <div class="row">
        <div class="col-md-12 offset-md-2">
          <div class="heading">
            <h3>{{ blog.title }}</h3>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-md-12 offset-md-2">
          <div class="full">
            <div class="big_blog">
              <img class="img-responsive" :src="blog.banner.url" :alt="blog.banner.title" />
            </div>
            <div class="blog_cont_2" v-html="blog.content.html_desktop">

            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "blogPostListComponent",
  props : ['blog']
}
</script>

<style scoped>

</style>