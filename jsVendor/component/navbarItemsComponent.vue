<template>
  <div class="card">
    <div class="select">
      <select name="slct" v-model="selectedNavbar">
        <option :value="{ id:0,name:'',url:''}">Yeni Menü Ekle</option>
        <option v-for="nav in navbars" :value="nav">{{ nav.name }} | {{nav.url}}</option>
      </select>
    </div>
    <div class="selected-navbar">
      <div class='full-input'>
        <label>Url</label>
        <input v-model="selectedNavbar.url" placeholder="Url">
      </div>
      <div class='full-input'>
        <label>Name</label>
        <input v-model="selectedNavbar.name" placeholder="Name">
      </div>
    </div>
    <div>
      <button @click="updateNavbar" v-if="selectedNavbar.id != 0" class="button btn-update">Güncelle</button>
      <button @click="deleteNavbar" v-if="selectedNavbar.id != 0" class="button btn-delete">Sil</button>
      <button @click="createNavbar" v-if="selectedNavbar.id == 0" class="button btn-create">Yarat</button>
    </div>
  </div>
</template>

<script>
export default {
  name: "navbarItemsComponent",
  data:function (){
    return {
      selectedNavbar:{ id:0,name:'',url:''},
    }
  },
  methods:{
    updateNavbar(){

    },
    deleteNavbar(){

    },
    createNavbar(){

    }
  },
  computed: {
    navbars(){
      return this.$store.state.navbars
    }
  }
}
</script>

<style scoped>
  select {
    -webkit-appearance: none;
    -moz-appearance: none;
    -ms-appearance: none;
    appearance: none;
    outline: 0;
    box-shadow: none;
    border: 0 !important;
    background: #ffffff;
    background-image: none;
    border-radius: 0;
    color: black;
  }
  select::-ms-expand {
    display: none;
  }
  .select {
    position: relative;
    display: flex;
    width: 256px;
    height: 3em;
    line-height: 3;
    background: #fdfdfd;
    overflow: hidden;
    border-radius: .25em;
    border: 2px solid grey;
  }
  select {
    flex: 1;
    padding: 0 .5em;
    cursor: pointer;
  }
  .select::after {
    content: '\25BC';
    position: absolute;
    top: 0;
    right: 0;
    padding: 0 1em;
    background: #fdfdfd;
    border-left: 1px solid black;
    cursor: pointer;
    pointer-events: none;
    -webkit-transition: .25s all ease;
    -o-transition: .25s all ease;
    transition: .25s all ease;
  }
  .select:hover::after {
    color: #f39c12;
  }
  .selected-navbar{
    /*margin-top: 0px;*/
    width: 300px;
  }

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

  .button{
    margin-top: 10px;
    padding: 15px 10px 15px 10px;
    width: 125px;
    font-weight: bold;
    font-size: 13px;
  }
  .btn-create{
    background: green;
  }
  .btn-delete{
    background: red;
  }
  .btn-update{
    background: #f4f4f4;
  }
</style>