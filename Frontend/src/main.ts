// IMPORTACIONES DE LAS LIBRERIAS NECESARIAS
import { createApp } from 'vue'
import { createPinia } from 'pinia'
import { createI18n } from 'vue-i18n'

// IMPORTACIONES DEL COMPONENTE PRINCIPAL Y ESTILOS GLOBALES
import App from './App.vue'
import router from './router/index'
import '@/styles/main.scss'

// IMPORTACION DE LA CONFIGURACION DE IDIOMAS
import es from "./locales/es.json"

const i18n = createI18n({
	legacy: false,
	locale: 'es',
	messages: {es}
})

// ARRANQUE DE APLICACION
const app = createApp(App)

// ACTIVACION DE LOS ARCHIVOS
app.use(createPinia())
app.use(router)
app.use(i18n)

app.mount('#app')
