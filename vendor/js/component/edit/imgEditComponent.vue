<template>
  <div id="input-img-popup" class="modal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
        </div>
        <div class="modal-body">
          <add-image @file-change="selectedImagesChange"></add-image>
          <input v-model="css">
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-primary" @click="($emit('click-item',url,css))">Kaydet</button>
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Kapat</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import AddImage from "../tools/addImage";
export default {
  name: "imgEditComponent",
  components: {AddImage},
  data:function (){
    return {
      url : null,
      css:null,
    }
  },
  methods:{
    selectedImagesChange(url){
      this.url = url;
    }
  }
}
</script>

<style scoped>

</style>