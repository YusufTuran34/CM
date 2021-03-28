<template>
  <div>
    <div class="aside">
      <div class="open-close-trigger" @click="editPageView = !editPageView">Aç Kapa</div>
      <div v-if="editPageView && selectedItem == null && readyForAddElement == null">
        <section>
          <label>Grid System</label>
          <div @click="addElement([{ 'el': 'div', 'class' : 'row','subElement' : [] }])">Satır</div>
          <div @click="addElement([{ 'el': 'div', 'class' : 'col-sm-12','subElement' : [] }])">12</div>
          <div @click="addElement([{ 'el': 'div', 'class' : 'col-sm-6', 'subElement' : [] },{'el': 'div', 'class' : 'col-sm-6', 'subElement' : [] }])">6 : 6</div>
          <div @click="addElement([{ 'el': 'div', 'class' : 'col-sm-8', 'subElement' : [] },{'el': 'div', 'class' : 'col-sm-4', 'subElement' : [] }])">8 : 4</div>
          <div @click="addElement([{ 'el': 'div', 'class' : 'col-sm-4', 'subElement' : [] },{'el': 'div', 'class' : 'col-sm-8', 'subElement' : [] }])">4 : 8</div>
          <div @click="addElement([{ 'el': 'div', 'class' : 'col-sm-2', 'subElement' : [] },{'el': 'div', 'class' : 'col-sm-10','subElement' : [] }])">2 : 10</div>
          <div @click="addElement([{ 'el': 'div', 'class' : 'col-sm-10','subElement' : [] },{'el': 'div', 'class' : 'col-sm-2', 'subElement' : [] }])">10 : 2</div>
          <div @click="addElement([{ 'el': 'div', 'class' : 'col-sm-4', 'subElement' : [] },{'el': 'div', 'class' : 'col-sm-4', 'subElement' : [] },{ 'el': 'div','class' : 'col-sm-4', 'subElement' : [] }])">4 : 4 : 4</div>
          <div @click="addElement([{ 'el': 'div', 'class' : 'col-sm-3', 'subElement' : [] },{'el': 'div', 'class' : 'col-sm-3', 'subElement' : [] },{ 'el': 'div','class' : 'col-sm-3', 'subElement' : [] },{ 'el': 'div','class' : 'col-sm-3', 'subElement' : [] }])">3 : 3 : 3 : 3</div>
        </section>
        <section>
          <label>Html</label>
          <div @click="addElement([{ 'el': 'label', 'text'  : 'Label' }])"> Label </div>
          <div @click="addElement([{ 'el': 'p',     'text'  : 'paragraf' }])"> Paragraf </div>
          <div @click="addElement([{ 'el': 'img',   'src'   : 'https://via.placeholder.com/150' }])"> Img </div>
        </section>
        <section>
          <label>Component</label>
          <div @click="addElement([{ 'el': 'legend','html'  : 'Custom' }])"> Summernote </div>
          <div @click="addElement([{ 'el': 'bulten'}])"> Bulten </div>
          <div @click="addElement([{ 'el': 'breadCrumb', 'urlList' : [{'url' : '/' , 'name' : 'Anasayfa'}]}])"> Bread Crumb </div>
          <div @click="addElement([{ 'el': 'slider','slider': {'someList':[ { 'html': 'slide1', 'style': { 'background': '#1bbc9b' } } ] ,'options' : {'currentPage': 0} } }])"> Slider </div>
          <div @click="addElement([{ 'el': 'recentpost','blogList' : [{'title':'title','date' : '24.01.2021','content' : { 'html_desktop' : 'Lorem ipsum dolar sit amet'}},{'title':'title','date' : '24.01.2021','content' : { 'html_desktop' : 'Lorem ipsum dolar sit amet'}},{'title':'title','date' : '24.01.2021','content' : { 'html_desktop' : 'Lorem ipsum dolar sit amet'}}] }])"> Recent Post </div>
          <div @click="addElement([{ 'el': 'blogList', 'pageUrl':'pageUrl', 'blogList' : [{'banner':{'url':'https://via.placeholder.com/150','title':'https://via.placeholder.com/150'},'url':'/','title':'title','date' : '24.01.2021','content' : { 'html_mini' : 'Lorem ipsum dolar sit amet'}},{'banner':{'url':'https://via.placeholder.com/150','title':'https://via.placeholder.com/150'},'url':'/','title':'title','date' : '24.01.2021','content' : { 'html_mini' : 'Lorem ipsum dolar sit amet'}}] }])"> Blog List </div>
        </section>
        <section>
          <div class="deleteEnable" @click="deleteModeTrigger"> Delete  </div>
          <div class="updateEnable" @click="update"> Update  </div>
        </section>
      </div>
    </div>

    <div class="page-main-view">
      <div :class="[readyForAddElement != null ? 'preview-active' : 'preview']">
        <header-component></header-component>
        <div style="background: white;position: relative;float: left;min-height: 300px;width: 100%">
          <html-object :elements="elements" @src-change="textChange" @css-change="cssChange" @remove-item="removeItem" @click-item="clickedItem" @text-change="textChange"></html-object>
        </div>
        <footer-component></footer-component>
      </div>
    </div>

    <div id="div-edit-css-popup" class="modal" tabindex="-1" role="dialog">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
          </div>
          <div class="modal-body">
            <input v-model="css">
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-primary" @click="saveCSS">Save changes</button>
            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
          </div>
        </div>
      </div>
    </div>

    <div id="input-edit-popup" class="modal" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
          <div class="modal-content">
            <div class="modal-header">
            </div>
            <div class="modal-body">
              <input v-model="text">
              <input v-model="css">
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-primary" @click="saveText">Save changes</button>
              <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
          </div>
        </div>
      </div>
    <div id="input-img-popup" class="modal" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
          <div class="modal-content">
            <div class="modal-header">
            </div>
            <div class="modal-body">
              <input v-model="text">
              <input v-model="css">
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-primary" @click="saveImg">Save changes</button>
              <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
          </div>
        </div>
      </div>
    <div id="input-bread-crumb-popup" class="modal" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
          <div class="modal-content">
            <div class="modal-header">
            </div>
            <div class="modal-body">
              <input v-model="text">
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-primary" @click="saveImg">Save changes</button>
              <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
          </div>
        </div>
      </div>
    <div id="legend-edit-popup" class="modal" tabindex="-1" role="dialog">
        <div class="modal-dialog modal-lg" role="document">
          <div class="modal-content">
            <div class="modal-header">
            </div>
            <div class="modal-body">
              <div id="summernote"></div>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-primary" @click="saveSummernote">Save changes</button>
              <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
          </div>
        </div>
      </div>

    <div v-show="selectedItem != null && selectedItem.el == 'bulten'">

    </div>
  </div>
</template>

<script>
console.log("17")
import HeaderComponent from "./ui/headerComponent";
import BultenComponent from "./general/bultenComponent";
import HtmlObject from "./general/htmlObject";
import FooterComponent from "./ui/footerComponent";
export default {
  name: "pagesComponent",
  components: {FooterComponent, HeaderComponent, BultenComponent, HtmlObject},
  data:function (){
    return {
      elements : [
        {
          "el"          : "div",
          "class"       : "container",
          "css"         : "",
          "subElement"  : [
            {
              "el"      : "div",
              "class"   : "row",
              "subElement" : [
                {
                  "el"          : "div",
                  "class"       : "col-sm-12",
                  "css"         : "",
                  "subElement"  : []
                }
              ]
            },
          ]
        }
      ],
      text : null,
      css : null,
      selectedItem : null,
      editPageView : false,
    }
  },
  methods:{
    update(){},
    deleteModeTrigger(){
      if(!this.$store.state.readyToDelete){
        setTimeout(function (){
          //FOR CSS
          setTimeout(function (){
            $($(".preview span")[0]).hide();
            $($(".preview span")[1]).hide();
            $($(".preview span")[2]).hide();
          },100)
        },100)
      }
      this.$store.state.readyToDelete = !this.$store.state.readyToDelete;
    },
    addElement(el){
      this.$store.dispatch("setReadyCreateElement",el)
      //FOR CSS
      setTimeout(function (){
        $($(".preview-active span")[0]).hide();
        $($(".preview-active span")[1]).hide();
        $($(".preview-active span")[2]).hide();

        $($(".preview-active span")[$(".preview-active span").length-1]).hide();
        $($(".preview-active span")[$(".preview-active span").length-2]).hide();
        $($(".preview-active span")[$(".preview-active span").length-3]).hide();
      },100);
    },
    clickedItem(item){
      let elements = item.element
      if(item.order == 'first'){
        for(var i=this.$store.state.element.length-1;i>=0;i--){
          elements.unshift(this.$store.state.element[i]);
        }
      }else if(item.order == 'last'){
        for(var i=0;i<this.$store.state.element.length;i++){
          elements.push(this.$store.state.element[i]);
        }
      }else{
        console.log("unexpected order for elements");
      }
      item.element = elements;
      this.$store.state.element = null;

    },
    removeItem(item){
      item = null;
    },

    textChange(item){
      if(item.el == 'legend'){
        $("#legend-edit-popup").modal('show')
      }else if(item.el == 'p' || item.el == 'label'){
        $("#input-edit-popup").modal('show')
      }else if(item.el == 'img'){
        $("#input-img-popup").modal('show')
      }else if(item.el == 'breadCrumb'){
        $("#input-bread-crumb-popup").modal('show')
      }
      this.selectedItem = item;
    },
    cssChange(item){
      if(item.el == 'div'){
        $("#div-edit-css-popup").modal('show')
      }
      this.selectedItem = item;
    },

    saveCSS(){
      this.selectedItem.css = this.css;
      this.selectedItem = null;
      this.css = null;
    },
    saveText(){
      this.selectedItem.text = this.text;
      this.selectedItem.css = this.css;
      this.selectedItem = null;
      this.text = null;
      this.css = null;
    },
    saveImg(){
      this.selectedItem.src = this.text;
      this.selectedItem.css = this.css;
      this.selectedItem = null;
      this.text = null;
    },
    saveSummernote(){
      this.selectedItem.html = $("#summernote").summernote('code');
      $("#summernote").summernote('code',null);
      $(".modal").modal('close');
      this.selectedItem = null;
      this.text = null;
    }
  },
  computed: {
    readyForAddElement(){
      return this.$store.state.element
    },
  },
  mounted() {
    $("#summernote").summernote({
      tabsize: 2,
      height: 400
    });
  }
}
</script>

<style>
  .aside{
    position: absolute;
    border: 1px solid black;
    z-index: 9999;
    background: #f4f4f4;

  }
  .aside .deleteEnable{
    width: 46%;
    float: left;
    margin-left:  2%;
    margin-right: 2%;
    margin-top: 5px;
    border: 4px solid red;
    text-align: center;
  }
  .aside .updateEnable{
    width: 46%;
    float: left;
    margin-left:  2%;
    margin-right: 2%;
    margin-top: 5px;
    border: 4px solid red;
    text-align: center;
  }
  .aside div{
    width: 100%;
    margin: 2px;
  }
  .aside div::before {
    content: "-   ";
  }
  .aside label{
    width: 100%;
    border-bottom: 1px solid red;
  }
  .aside section{
    width: 45%;
    margin-left: 2.5%;
    margin-right: 2.5%;
    float: left;
    position: relative;
  }
  .preview{
    border: 1px solid black;
    width: 100%;
    float: left;
    position: relative;
    min-height: 75%;
  }
  .preview-active{
    border: 2px solid black;
    width: 100%;
    float: left;
    position: relative;
    min-height: 75%;
  }
  .preview-active .container{
    border: 1px solid #212529;
    min-height: 50px;
    position: relative !important;
    float: left !important;
    width: 90%  !important;
    margin: 5%  !important;
    margin: 5%  !important;
  }
  .preview-active .row{
    border: 1px solid #212529;
    min-height: 50px;
    position: relative !important;
    float: left !important;
    width: 90%  !important;
    margin: 5%  !important;
    margin: 5%  !important;
  }

  .preview .active-show-border{
    height: auto;
    float: left;
    position: relative;
    width: 100%;
  }

  .preview-active .active-show-border{
    border: 2px solid red !important;
    height: auto;
    float: left;
    position: relative;
    width: 100%;
  }
  .preview-active .active-show-border span{
    width: 100%;
    border: 1px solid black;
    float: left;
    position: relative;
  }
</style>