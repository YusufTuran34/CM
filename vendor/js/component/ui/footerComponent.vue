<template>
  <footer>
    <div class="container">
      <div class="row">
        <div class="col-lg-3 col-md-3" v-if="settings != null" >
          <a :href="' /'"><img :src="settings.logo.url" :alt="settings.logo.title" /></a>
          <ul class="social_icon">
            <li v-if="settings.socialMedia.facebookUrl.facebookUrl != null"><a :href="settings.socialMedia.facebookUrl"><i class="fa fa-facebook"></i></a></li>
            <li v-if="settings.socialMedia.facebookUrl.twitterUrl != null"><a :href="settings.socialMedia.twitterUrl"><i class="fa fa-twitter"></i></a></li>
            <li v-if="settings.socialMedia.facebookUrl.linkedinUrl != null"><a :href="settings.socialMedia.linkedinUrl"><i class="fa fa-linkedin"></i></a></li>
            <li v-if="settings.socialMedia.facebookUrl.youtubeUrl != null"><a :href="settings.socialMedia.youtubeUrl"><i class="fa fa-youtube"></i></a></li>
            <li v-if="settings.socialMedia.facebookUrl.pinterestUrl != null"><a :href="settings.socialMedia.pinterestUrl"><i class="fa fa-pinterest"></i></a></li>
          </ul>
        </div>
        <div class="col-lg-9 col-md-9">
<!--          <recent-post-component></recent-post-component>-->
        </div>
      </div>
    </div>
  </footer>
</template>

<script>
import RecentPostComponent from "./blog/recentPostComponent";
export default {
  name: "footerComponent",
  components: {RecentPostComponent},
  computed: {
    settings(){
      return this.$store.state.settings
    }
  }
}
</script>

<style scoped>

</style>