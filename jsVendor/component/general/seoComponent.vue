<template>
  <div>
    <div class='full-input'>
      <label>Başlık</label>
      <input v-model="seo.title" placeholder="Başlık">
    </div>
    <div class='full-input'>
      <label>Açıklama</label>
      <input v-model="seo.description" placeholder="Açıklama">
    </div>
    <div class='full-input'>
      <label>Keywords</label>
      <input v-model="seo.keywords" placeholder="keywords">
    </div>
    <div class='full-input'>
      <label>ogtitle</label>
      <input v-model="seo.ogtitle" placeholder="ogtitle">
    </div>
    <div class='full-input'>
      <label>ogdescription</label>
      <input v-model="seo.ogdescription" placeholder="ogdescription">
    </div>
    <div class='full-input'>
      <label>ogtype</label>
      <input v-model="seo.ogtype" placeholder="ogtype">
    </div>
    <div class='full-input'>
      <label>ogsite_name</label>
      <input v-model="seo.ogsite_name" placeholder="ogsite_name">
    </div>
    <div class='full-input'>
      <label>ogimage</label>
      <input v-model="seo.ogimage" placeholder="ogimage">
    </div>
    <div class='full-input'>
      <label>ogurl</label>
      <input v-model="seo.ogurl" placeholder="ogurl">
    </div>
    <div class='full-input'>
      <label>yandexVerification</label>
      <input v-model="seo.yandexVerification" placeholder="yandexVerification">
    </div>
    <div class='full-input'>
      <label>msvalidate01</label>
      <input v-model="seo.msvalidate01" placeholder="msvalidate01">
    </div>
    <div class='full-input'>
      <label>canonical</label>
      <input v-model="seo.canonical" placeholder="canonical">
    </div>
  </div>
</template>

<script>
export default {
  name: "seoComponent",
  model: {
    prop: 'seo',
    event: 'change'
  },
  props:['seo']
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