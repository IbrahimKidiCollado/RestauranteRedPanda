import {defineStore} from 'pinia';
import { ref } from 'vue';
import { loguearse, desloguearse, registrar } from '@/services/Tienda/LoginService';

export const useUserStore = defineStore('user', () => {

    const logueado = ref(false);
    const esAdmin = ref(false);
    const nombreUsuario = ref('');
    const emailUsuario = ref('');
    const passwordUsuario = ref('');
    const sesionActiva = ref(false);
    const prefenciaIdioma = ref('');
    const id = ref(0);
    const preferencia_idioma = ref('');


    async function login(nombre: string, email: string, pwd: string) {
        logueado.value = true;
        nombreUsuario.value = nombre;
        emailUsuario.value = email;
        passwordUsuario.value = pwd;

        //Llamada a la funcion de Login del servicio
        const resultado = await loguearse( email, pwd);
        if (resultado) {
            logueado.value = true;
            sesionActiva.value = true;
            id.value = resultado.id;
            nombreUsuario.value = resultado.nombre;
            emailUsuario.value = resultado.email;
            prefenciaIdioma.value = resultado.preferencia_idioma;

            if (resultado.nombre === 'admin') {
                esAdmin.value = true;
                console.log(resultado);
            }
            console.log('Usuario logueado:', {
                nombre: resultado.nombre,
                email: emailUsuario.value,
                password: passwordUsuario.value
            });
            return true;
        }

        return false;
    }

    async function registrarse( nombre: string, email: string, pwd: string) {
        //Si el usuario manda datos vacios
        if(!nombre.trim() || !email.trim() || !pwd.trim()){
            return false
        }

        //Si el correo tiene formato incorrecto
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if(!emailRegex.test(email)){
            return false
        }
        const resultado = await registrar(nombre, email, pwd);
        if (resultado) {
            logueado.value = true;
            nombreUsuario.value = nombre;
            emailUsuario.value = email;
            passwordUsuario.value = pwd;
            sesionActiva.value = true;
            return true;
        }
        return false;
    }

    async function logout() {
        logueado.value = false;
        emailUsuario.value = '';
        nombreUsuario.value = '';
        passwordUsuario.value = '';
        esAdmin.value = false;
        id.value = 0;
        sesionActiva.value = false;
        console.log("cierras sesion");
        prefenciaIdioma.value = '';
        return true;
    }

    //Para recuperar la sesión al recargar la pagina
    function recuperarSesion() {
        console.log("DEBUG: Entrando en recuperarSesion...");
        const usuarioGuardado = localStorage.getItem('usuario_redpanda');
        
        if (!usuarioGuardado) {
            console.warn("DEBUG: No hay nada en localStorage bajo 'usuario_redpanda'");
            return;
        }

        try {
            const data = JSON.parse(usuarioGuardado);
            console.log("DEBUG: Datos encontrados en Storage:", data);
            
            id.value = data.id;
            nombreUsuario.value = data.nombre;
            emailUsuario.value = data.email;
            sesionActiva.value = true;
            logueado.value = true;
            
            if (data.nombre === 'admin') {
                esAdmin.value = true;
            }
            console.log("DEBUG: Estado del Store actualizado correctamente.");
        } catch (error) {
            console.error("DEBUG: Error al parsear JSON del Storage:", error);
        }
    }

    return{
        logueado,
        nombreUsuario,
        emailUsuario,
        passwordUsuario,
        id,
        registrarse,
        login,
        logout,
        esAdmin,
        sesionActiva,
        prefenciaIdioma,
        recuperarSesion
    }

});