import {defineStore} from 'pinia';
import { ref } from 'vue';
import { loguearse, desloguearse, registrar } from '@/services/Tienda/LoginService';

export const useUserStore = defineStore('user', () => {

    const logueado = ref(true);
    const esAdmin = ref(false);
    const nombreUsuario = ref('');
    const emailUsuario = ref('');
    const passwordUsuario = ref('');
    const sesionActiva = ref(false);
    const id = ref(0);


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
        logueado.value = true;
        nombreUsuario.value = nombre;
        emailUsuario.value = email;
        passwordUsuario.value = pwd;

        const resultado = await registrar(nombre, email, pwd);
        if (resultado) {
            logueado.value = true;
            console.log('Usuario registrado:', {
                nombre: nombreUsuario.value,
                email: emailUsuario.value,
                password: passwordUsuario.value
            });
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
        sesionActiva.value = false;
        return true;
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
        sesionActiva
    }

});
