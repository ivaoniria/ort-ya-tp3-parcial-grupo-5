# Parcial TP3 - Grupo 5 — Android App

# FinanzasApp TP3

**FinanzasApp TP3** permite registrar y monitorear ingresos y egresos, ofreciendo una herramienta intuitiva para la gestión de finanzas personales o comerciales.  
Incluye estadísticas, reportes dinámicos, categorización de gastos, metas de ahorro y alertas inteligentes para mejorar hábitos financieros.

------

# Integrantes

- Liscovsky, Iván
- Serrudo Arteaga, Carlos
- Taddeo, Leandro Christian
- Velasquez Garcia, Gustavo

------

## Cuestionario

**1️. ¿Qué tipo de arquitectura usaron y por qué? ¿Podría mejorarla?**

Usamos una arquitectura MVVM (Model–View–ViewModel) con una estructura en capas bien separadas:
Data: contiene las implementaciones de Room y Retrofit, que manejan la persistencia local y las peticiones a la API.
Domain: define los modelos y las interfaces de los repositorios.
Presentation: incluye los ViewModels y las pantallas de Compose.
DI: usamos Hilt para la inyección de dependencias.
Elegimos MVVM porque separa claramente la lógica de negocio de la UI, lo que facilita el mantenimiento y las pruebas.
Podría mejorarse aplicando algunos principios del Clean Architecture, agregando mappers dedicados entre las capas (como el que se aplicó para Transactions, pero para los otros modelos) y unificando el manejo de resultados (por ejemplo, usar una sola clase Result o UiState).

**2️. ¿Tuvieron objetos stateful y stateless? ¿Cómo definen la elección de los mismos? Comenten al menos 2 cuestiones a refactorizar y tener en cuenta. **

Sí, tuvimos ambos tipos. Los stateful (por ejemplo, los ViewModel) conservan el estado entre recomposiciones y manejan datos provenientes de la red o la base de datos. Los stateless (como la mayoría de los @Composable de UI) solo muestran información y dependen de los parámetros que reciben.La elección se define según la responsabilidad del componente: Si necesita mantener datos o reaccionar a cambios de fuente, lo hacemos stateful. Si solo representa la UI y delega el manejo de estado a otro nivel, lo hacemos stateless. En resumen, la UI debe ser declarativa y predecible, y el estado se maneja en los ViewModels.

**3. ¿Qué mejoras detectan que podrían realizarle a la app?**

Podríamos aplicar varias mejoras, pero destacamos tres principales:
Componentizar mejor los Background o Shape de los distintos Drawables existentes. Pensamos implementar un componente global que reciba por parámetro Drawable, color y dimensiones para poder implementarlos en casi todas las pantallas.
No se utilizó correctamente el Theme/AppTypography que diseñamos en un principio. Podría haberse utilizado en varias partes de presentations en vez de manejar singluarmente las características de cada text y string.
Unificar el manejo de errores y estados: actualmente hay varios enfoques (Result, Response, etc.). Deberíamos definir una única clase UiState con los estados Loading, Success y Error, para que la UI reaccione de forma consistente.

**4️. ¿Qué manejo de errores harían? ¿Dónde los contemplan a nivel código? ¿Qué estrategia de mapeo aplicarían?**

Implementaríamos un mapeo de errores por capas con una clase AppError definida en domain, que distinga casos como Network, Http, Database, Unauthorized, etc. En la capa data, se mapean las excepciones de Retrofit, Room y otros orígenes a tipos de AppError. En la capa domain, se propagan como Result.Failure(AppError) o UiState.Error(AppError). En la presentación, el ViewModel los interpreta y la UI muestra un mensaje o una acción de “Reintentar”. Esta estrategia permite mantener los errores controlados, tipados y sin filtrar excepciones técnicas hacia la UI.

**5. Si la tendríamos que convertir a Español y conservar el Inglés, ¿qué estrategia utilizarían? ¿Y si necesitamos agregar otros idiomas?**

Aprovecharíamos el sistema de internacionalización (i18n) de Android. Manteneniendo los textos en res/values/strings.xml (inglés por defecto). Crear carpetas values-es/, values-pt/, etc. con las traducciones correspondientes. Usar: stringResource(id = R.string.xxx) en Compose (ya lo hacemos). Para cambiar el idioma en tiempo real, usar AppCompatDelegate.setApplicationLocales() y guardar la preferencia en DataStore. Si se suman más idiomas, solo se agregan nuevos archivos strings.xml por idioma. También sería necesario cuidar los formatos de fecha, moneda y las longitudes del texto según el Local.

------

## Tecnologías principales

- **Kotlin** – Lenguaje principal
- **Jetpack Compose** – Interfaz moderna y declarativa
- **Hilt / Dagger** – Inyección de dependencias
- **Room (SQLite ORM)** – Base de datos local
- **KSP** – Kotlin Symbol Processing (para Room y Hilt)
- **Retrofit + OkHttp** – Consumo de API REST
- **Coil** – Carga y caché de imágenes
- **Navigation Compose** – Navegación entre pantallas
- **Material 3** – Diseño visual adaptativo

------

## Implementaciones del proyecto

**Implementaciones y criterios de evaluación
Funcionalidad**

La aplicación funciona correctamente en todas sus pantallas principales, cumpliendo con la navegación entre secciones, la carga de datos remotos y el manejo persistente de información local.
Se verificó que las acciones principales (crear usuario, navegar, listar elementos, cerrar sesión) se ejecutan de manera fluida y coherente con el flujo de la app.

**Diseño & Estética**

La interfaz fue maquetada sin Relay, aplicando principios de consistencia visual, jerarquía tipográfica y paleta cromática uniforme, siguiendo la identidad de la marca FinWise.
Se respetan los márgenes, el espaciado y las proporciones entre elementos, utilizando componentes de Material 3 con una estética moderna y legible.

**Utilización de componentes**

Se emplean componentes de Jetpack Compose como Column, Row, Card, LazyColumn, Button, TextField, Image y Surface, además de estructuras más complejas personalizadas.
La UI se compone mediante componentes reutilizables y desacoplados, muchos de ellos stateless, que reciben los datos desde ViewModels y repositorios.

**Navegación**

Se implementó el componente de navegación de Jetpack (NavHost, NavController, NavGraph) para permitir una transición fluida entre pantallas.
Las rutas están definidas de forma centralizada en un archivo de constantes, lo que facilita la escalabilidad y el mantenimiento del flujo de la aplicación.

**Room**

La aplicación utiliza Room como criterio de persistencia de datos.
Se implementó persistencia en memoria reflejada en la ProfileScreen:

Al crear una cuenta, se registra la información del usuario y su correo electrónico en la base local.

El nombre del usuario se muestra en la interfaz de perfil.

Si el usuario selecciona Logout, los datos se eliminan de la base.

Si el usuario cierra la app y la vuelve a abrir, la información persiste correctamente, garantizando la integridad de los datos.

**Retrofit**

Se aplica Retrofit como capa de comunicación con servicios externos.
La app obtiene mocks remotos y alimenta las distintas pantallas (por ejemplo, listados y secciones de inicio) con esos datos simulando una API real.
Se incluye una estructura escalable que permite reemplazar fácilmente los mocks por endpoints reales en caso de integración futura.

**Listado de ítems**

Se implementan listados dinámicos mediante LazyColumn, mostrando información proveniente de Retrofit o de los repositorios locales (Room).
Los ítems se representan con componentes visuales personalizados (TransactionItem, CategoryButton, NotificationItem, etc.) con comportamiento responsivo y adaptable a diferentes estados.

**Utilización de ViewModel**

Se aplicó el patrón MVVM, utilizando ViewModels para manejar estado y lógica de presentación.
Cada ViewModel expone estados observables (mutableStateOf, StateFlow) a los Composables, promoviendo una arquitectura reactiva y desacoplada.

**Arquitectura y estructura de la solución**

La solución sigue una arquitectura modular MVVM, separada en capas:

data → persistencia (Room) y red (Retrofit).
domain → modelos y contratos de repositorios.
presentation → pantallas Compose, ViewModels y componentes de UI.

di → inyección de dependencias mediante Hilt.

Esta organización mejora la mantenibilidad y el testeo, garantizando independencia entre lógica, datos y presentación.

**Extras**

Se implementó Inyección de dependencias con Hilt, reduciendo acoplamiento.

Se preparó el sistema de Dark Mode / Light Mode mediante la configuración de temas en Theme.kt.

Se aplicó tipografía Poppins y una paleta de color adaptada al diseño.
