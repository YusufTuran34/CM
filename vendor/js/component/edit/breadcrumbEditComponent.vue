<template>
  <div id="input-bread-crumb-popup" class="modal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
        </div>
        <div class="modal-body">
          <div v-for="(urlObj,index) in urlList">
            <input v-model="urlObj.url">
            <input v-model="urlObj.name">
            <span @click="removeUrl(index)">-</span>
          </div>
          <span @click="addUrlList">+</span>

        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-primary" @click="($emit('click-item',urlList))">Kaydet</button>
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Kapat</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "breadCrumbEditComponent",
  props:['urlList'],
  methods:{
    addUrlList(){
      this.urlList.push({'url':'/','name':''})
    },
    removeUrl(index){
      this.urlList.splice(index,1);
    },
  },
}
</script>

<style scoped>

</style>