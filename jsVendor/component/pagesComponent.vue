<template>
  <div>
    <div class="aside">
      <label>Grid System</label>
      <div @click="addElement([{ 'el': 'div',   'class' : 'col-sm-12','subelement' : [] }])">12</div>
      <div @click="addElement([{ 'el': 'div',   'class' : 'col-sm-6', 'subelement' : [] },{'el': 'div', 'class' : 'col-sm-6', 'subelement' : [] }])">6 : 6</div>
      <div @click="addElement([{ 'el': 'div',   'class' : 'col-sm-8', 'subelement' : [] },{'el': 'div', 'class' : 'col-sm-4', 'subelement' : [] }])">8 : 4</div>
      <div @click="addElement([{ 'el': 'div',   'class' : 'col-sm-4', 'subelement' : [] },{'el': 'div', 'class' : 'col-sm-4', 'subelement' : [] },{ 'el': 'div','class' : 'col-sm-4', 'subelement' : [] }])">4 : 4 : 4</div>
      <div @click="addElement([{ 'el': 'label', 'text'  : 'Label' }])"> Label </div>
      <div @click="addElement([{ 'el': 'p',     'text'  : 'paragraf' }])"> Paragraf </div>
      <div @click="addElement([{ 'el': 'legend','html'  : 'Custom' }])"> Summernote </div>

    </div>

    <html-object :elements="elements" @click-item="clickedItem" @text-change="textChange"></html-object>
    <div v-show="selectedItem != null && selectedItem.el != 'legend'">
      <input v-model="text">
      <button @click="saveText"> Kaydet </button>
    </div>
    <div v-show="selectedItem != null && selectedItem.el == 'legend'">
      <div id="summernote"></div>
      <button @click="saveSummernote"> Kaydet </button>
    </div>
  </div>
</template>

<script>
import HtmlObject from "./pageGame/htmlObject";
export default {
  name: "pagesComponent",
  components: {HtmlObject},
  data:function (){
    return {
      elements : [
        {
          "el"          : "div",
          "class"       : "container",
          "css"         : "",
          "subelement"  : [
            {
              "el"      : "div",
              "class"   : "row",
              "subelement" : [
                {
                  "el"      : "div",
                  "class"   : "col-sm-12",
                  "subelement" : []
                },
              ]
            },
          ]
        }
      ],
      text : null,
      selectedItem : null,
    }
  },
  methods:{
    addElement(el){
      this.$store.dispatch("setReadyCreateElement",el)
    },
    clickedItem(item){
      for(var i=0;i<this.$store.state.element.length;i++){
        item.push(this.$store.state.element[i]);
      }
      this.$store.state.element = null;
    },
    textChange(item){
      this.selectedItem = item;
    },

    saveText(){
      this.selectedItem.text = this.text;
      this.selectedItem = null;
      this.text = null;
    },
    saveSummernote(){
      this.selectedItem.html = $("#summernote").summernote('code');
      $("#summernote").summernote('code',null);
      this.selectedItem = null;
      this.text = null;
    }
  },
  computed: {
    readyForAddElement(){
      return this.$store.state.element
    }
  },
  mounted() {
    $("#summernote").summernote();
  }
}
</script>

<style>
  .container{
    margin: 10px;
    background: aqua;
  }
  .row{
    margin: 10px;
    background: blueviolet;
  }
  label{
    margin: 10px;
    background: brown;
  }
</style>