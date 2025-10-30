# TP3 Parcial Grupo 5 — Android App

# FinanzasApp TP3

**FinanzasApp TP3** permite registrar y monitorear ingresos y egresos, ofreciendo una herramienta intuitiva para la gestión de finanzas personales o comerciales.  
Incluye estadísticas, reportes dinámicos, categorización de gastos, metas de ahorro y alertas inteligentes para mejorar hábitos financieros.

---

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

---

## Estructura del proyecto
app/
├─ di/ → Módulos de Hilt
├─ data/ → Repositorios y acceso a datos
├─ domain/ → Modelos y lógica de negocio
├─ presentation/ → Pantallas (Compose)
│ ├─ home_page/
│ ├─ login/
│ └─ components/
├─ ui/theme/ → Colores, tipografía y estilos
└─ MainActivity.kt → Punto de entrada principal

---

## Cómo clonar y ejecutar

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/ivaoniria/ort-ya-tp3-parcial-grupo-5.git
   cd tuNuveoRepo
