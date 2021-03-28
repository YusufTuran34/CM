<template>
  <div>
    <div class='full-input'>
      <label>facebookUrl</label>
      <input v-model="socialMedia.facebookUrl" placeholder="facebookUrl">
    </div>
    <div class='full-input'>
      <label>twitterUrl</label>
      <input v-model="socialMedia.twitterUrl" placeholder="twitterUrl">
    </div>
    <div class='full-input'>
      <label>pinterestUrl</label>
      <input v-model="socialMedia.pinterestUrl" placeholder="pinterestUrl">
    </div>
    <div class='full-input'>
      <label>youtubeUrl</label>
      <input v-model="socialMedia.youtubeUrl" placeholder="youtubeUrl">
    </div>
    <div class='full-input'>
      <label>linkedinUrl</label>
      <input v-model="socialMedia.linkedinUrl" placeholder="linkedinUrl">
    </div>
  </div>
</template>

<script>
export default {
  name: "socialMediaComponent",
  model: {
    prop: 'socialMedia',
    event: 'change'
  },
  props:['socialMedia']
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