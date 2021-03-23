<template>
  <div>
    <label>{{label}}</label>
    <div class='full-input'>
      <label>Url</label>
      <input v-model="img.url" placeholder="Url">
    </div>
    <div class='full-input'>
      <label>Adı</label>
      <input v-model="img.title" placeholder="Adı">
    </div>
  </div>
</template>

<script>
export default {
  name: "imgComponent",
  model: {
    prop: 'img',
    event: 'change'
  },
  props: {
    img:Object,
    label:String
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