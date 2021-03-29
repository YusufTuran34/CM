<template>
  <div id="input-edit-popup" class="modal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
        </div>
        <div class="modal-body">
          <div class="row">
            <div class="col-sm-6">
              <label>Text</label>
              <input v-model="text">
            </div>
            <div class="col-sm-6">
              <label>CSS</label>
              <input v-model="css">
            </div>
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-primary" @click="($emit('click-item',text,css))">Kaydet</button>
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Kapat</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "inputEditComponent",
  data:function (){
    return {
      text : null,
      css:null,
    }
  }
}
</script>

<style scoped>

</style>