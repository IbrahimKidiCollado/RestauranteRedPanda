import {defineStore} from 'pinia';
import { ref } from 'vue';
import { loguearse, desloguearse, registrar } from '@/services/Tienda/LoginService';

export const useUserStore = defineStore('user', () => {

    const logueado = ref(true);
    const esAdmin = ref(false);
    const nombreUsuario = ref('');
    const emailUsuario = ref('');
    const passwordUsuario = ref('');

    async function login(nombre: string, email: string, pwd: string) {
        logueado.value = true;
        nombreUsuario.value = nombre;
        emailUsuario.value = email;
        passwordUsuario.value = pwd;

        //Llamada a la funcion de Login del servicio
        const resultado = await loguearse( email, pwd);
        if (resultado) {
            logueado.value = true;
            if (resultado.nombre === 'admin') {
                esAdmin.value = true;
                console.log('Usuario admin logueado:', {
                    nombre: nombreUsuario.value,
                    email: emailUsuario.value,
                    password: passwordUsuario.value
                });
            }
            console.log('Usuario logueado:', {
                nombre: nombreUsuario.value,
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
            return true;
        }
        return false;
    }

    async function logout() {
        logueado.value = false;
        emailUsuario.value = '';
        nombreUsuario.value = '';
        return true;
    }

    return{
        logueado,
        nombreUsuario,
        emailUsuario,
        passwordUsuario,
        registrarse,
        login,
        logout,
        esAdmin
    }

});
