<template>
  <div class="header">
    <div class="logo">
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
  .header {
    float: left;
    position: relative;
    width: 15%;
    background-color: #42444e;
    height: 100%;
  }
  .header .logo{
    width: 100%;
    background-image: url("https://via.placeholder.com/150");
    height: 75px;
  }
  .header a{
    margin-left: 40px;
    padding-left: 40px;
    padding-top: 10px;
    padding-bottom: 10px;
    margin-right: 40px;
    float: left;
    font-size: 17px;
    width: calc(100% - 80px);
    color: whitesmoke;
    border-bottom: 1px solid whitesmoke;
    border-top: 1px solid whitesmoke;


  }
</style>