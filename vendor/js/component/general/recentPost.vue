<template>
  <div>
    <div v-for="recentPost in recentPostList">
      <div class="col-sm-12">
        <label>{{recentPost.title}}</label>
        <p>{{recentPost.content.html_desktop}}</p>
        <small>{{recentPost.content.date}}</small>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "recentPost",
  props: {
    recentPostList:Array,
  }
}
</script>

<style scoped>

</style>