import Vue from 'vue'
import App from './App.vue'
import router from './router'

Vue.config.productionTip = false
// Vue.http.options.root = 'http://localhost:8080/'
// Vue.http.headers.common['Access-Control-Allow-Origin'] = true
// Vue.http.headers.common['Access-Control-Allow-Origin'] = '*'

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
