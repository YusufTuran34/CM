<template>
  <div @dblclick="$emit('bread-crumb-change',breadCrumbPageList)">
    <ul class="breadcrumb">
      <li v-for="page in breadCrumbPageList"><a :href="page.url">{{ page.name }}</a></li>
    </ul>
  </div>
</template>

<script>
export default {
  name: "breadCrumbComponent",
  props : ['breadCrumbPageList']
}
</script>

<style scoped>

</style>