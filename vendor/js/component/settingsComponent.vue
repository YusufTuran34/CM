<template>
  <div v-if="settings != null">
    <img-component :label="'logo'" v-model="settings.logo"></img-component>
    <img-component :label="'favIcon'" v-model="settings.favIcon"></img-component>
    <div class='full-input'>
      <label>Analytics Id</label>
      <input v-model="settings.analyticsId" placeholder="analytics id">
    </div>
    <div class='full-input'>
      <label>Tag Manager Id</label>
      <input v-model="settings.tagManagerId" placeholder="tagManager id">
    </div>
    <seo-component v-model="settings.seo"></seo-component>
    <social-media-component v-model="settings.socialMedia"></social-media-component>
    <div>
      <button @click="updateSettings" class="button btn-update">Güncelle</button>
    </div>
  </div>
</template>

<script>
import ImgComponent from "./general/imgComponent";
import SeoComponent from "./general/seoComponent";
import SocialMediaComponent from "./general/socialMediaComponent";
export default {
  name: "settingsComponent",
  components: {SocialMediaComponent, SeoComponent, ImgComponent},
  created() {

  },
  methods:{
    updateSettings(){
      this.$store.dispatch("setSettings",this.settings)
    }
  },
  computed: {
    settings(){
      return this.$store.state.settings
    }
  }
}
</script>

<style scoped>
  .full-input {
    display: inline-block;
    padding: 3px;
    border: 2px solid grey;
    margin-top: 5px;
  }
  input {
    outline: none;
    border: none;
    display:block;
    line-height: 1.2em;
    font-size: 14pt;
    width: 250px;
  }
  label {
    display: block;
    font-size: 12px;
    color: black;
  }
</style>