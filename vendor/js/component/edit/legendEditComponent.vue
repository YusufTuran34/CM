<template>
  <div id="legend-edit-popup" class="modal" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-lg" role="document">
      <div class="modal-content">
        <div class="modal-header">
        </div>
        <div class="modal-body">
          <div id="summernote"></div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-primary" @click="saveSummernote">Kaydet</button>
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Kapat</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "legendEditComponent",
  methods:{
    saveSummernote(){
      this.$emit('clicked-item',$("#summernote").summernote('code'))
    }
  },
  mounted() {
    $("#summernote").summernote()
  }
}
</script>

<style scoped>

</style>