<template>
  <header>
    <div class="container-fluid">
      <div class="row">
        <div class="col-lg-3 logo_section">
          <div class="full">
            <div class="center-desk" v-if="settings != null">
              <div class="logo"> <a href="/"><img :src="settings.logo.url" :alt="settings.logo.title"></a> </div>
            </div>
          </div>
        </div>
        <div class="col-lg-9">
          <div class="menu-area">
            <div class="limit-box">
              <nav class="main-menu">
                <ul class="menu-area-main">
                  <li v-for="navbar in navbars">
                    <a :href="'/'+navbar.url">{{ navbar.name }}</a>
                  </li>
                </ul>
              </nav>
            </div>
          </div>
        </div>
      </div>
    </div>
  </header>
</template>

<script>
export default {
  name: "headerComponent",
  computed: {
    settings(){
      return this.$store.state.settings
    },
    navbars(){
      return this.$store.state.navbars
    }
  }
}
</script>

<style scoped>

</style>