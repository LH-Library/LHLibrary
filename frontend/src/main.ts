import 'bootstrap/dist/css/bootstrap.css'
import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

/* import the fontawesome core */
import { library } from '@fortawesome/fontawesome-svg-core'

/* import font awesome icon component */
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'

/* import specific icons */
import { faBookOpenReader, faUsers, faUser, faHouse} from '@fortawesome/free-solid-svg-icons'

library.add(faBookOpenReader, faUsers, faUser, faHouse)

createApp(App)
.component('font-awesome-icon', FontAwesomeIcon)
.use(store).use(router).mount('#app')

import 'bootstrap/dist/js/bootstrap.js'