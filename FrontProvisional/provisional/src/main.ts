// IMPORTACIONES DE LAS LIBRERIAS NECESARIAS
import { createApp } from 'vue'
import { createPinia } from 'pinia'
import { createI18n } from 'vue-i18n'

// IMPORTACIONES DEL COMPONENTE PRINCIPAL Y ESTILOS GLOBALES
import App from './App.vue'
import router from './router/index'

// IMPORTACION DE LA CONFIGURACION DE IDIOMAS
import es from "./locales/es.json"

// ARRANQUE DE APLICACION
const app = createApp(App)

// ACTIVACION DE LOS ARCHIVOS
app.use(createPinia())
app.use(router)
app.use(createI18n)

app.mount('#app')
