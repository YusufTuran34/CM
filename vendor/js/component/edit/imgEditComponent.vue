<template>
  <div id="input-img-popup" class="modal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
        </div>
        <div class="modal-body">
          <div class="row">
            <div class="col-sm-6">
              <img :src="selectedItem.src">
              <add-image @file-change="selectedImagesChange" :btn-name="'Yükle'"></add-image>
            </div>
            <div class="col-sm-6">
              <css-editor v-model="selectedItem.css"></css-editor>
            </div>
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-primary" @click="($emit('click-item',url,selectedItem.css))">Kaydet</button>
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Kapat</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import AddImage from "../tools/addImage";
import CssEditor from "../tools/cssEditor";
export default {
  name: "imgEditComponent",
  components: {CssEditor, AddImage},
  model: {
    prop: 'selectedItem',
    event: 'change'
  },
  props:['selectedItem'],
  data:function (){
    return {
      url: null,
    }
  },
  methods:{
    selectedImagesChange(url){
      this.url = url;
    }
  },
}
</script>

<style scoped>

</style>