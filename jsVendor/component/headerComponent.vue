<template>
  <div class="header">
    <div class="logo">
      logo
    </div>
    <router-link to="/" tag="a">Anasayfa</router-link>
    <router-link to="/user" tag="a">User</router-link>
    <router-link to="/navbar" tag="a">Navbar</router-link>
    <router-link to="/settings" tag="a">Settings</router-link>
    <router-link to="/pages" tag="a">Pages</router-link>
  </div>
</template>

<script>
export default {
  name: "headerComponent",
}
</script>

<style scoped>
  .header{
    float: left;
    position: fixed;
    width: 200px;
    background: #DADDE2;
    height: 90%;
  }
  .header a{
    width: 100px;
    float: left;
    position: relative;
    background: #DADDE2;
    color: #43655A;
    font-size: 15px;
    font-weight: bold;
    padding-top: 15px;
    padding-bottom: 15px;
    padding-left: 45px;
    padding-right: 45px;
    margin-left: 5px;
    margin-right: 5px;
    border-bottom: 1px solid whitesmoke;
  }
  .header a:hover{
    background: #43655A;
    color: white;
  }
  .header .logo{
    width: 100%;
    background: #43655A;
    height: 50px;
  }
</style>