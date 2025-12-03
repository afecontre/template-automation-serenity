tura Cypress equivalente 1:1 (misma filosofía)
🔹 3. Te doy un estándar profesional para ambos templates

(para que todo tu GitHub tenga un solo estilo técnico)

📄 3. README.md DEFINITIVO

(Ajustado EXACTAMENTE al template que acabas de mostrar)
Cópialo y pégalo DIRECTO en tu repositorio Selenium:
template-automation-serenity

# 🧪 Template de Automatización E2E con Serenity BDD + Selenium  
Plantilla oficial para crear proyectos de automatización end-to-end utilizando **Serenity BDD**, **Selenium WebDriver**, **Screenplay Pattern**, **Gradle** y **JUnit**.

Este template está diseñado para iniciar proyectos nuevos de forma rápida y con una arquitectura profesional, limpia, modular y escalable.

---

## 🎯 Objetivo del Template

Este repositorio sirve como base para:

✔ Crear proyectos de automatización desde cero  
✔ Mantener buenas prácticas con Screenplay  
✔ Separar UI, Tasks, Interactions y Questions  
✔ Escribir pruebas legibles con Gherkin  
✔ Generar reportes ejecutivos con Serenity  
✔ Integrar fácilmente en CI/CD  

---

## 📁 Estructura del Proyecto



src
├── main/java/
│ ├── interactions/ # Interacciones avanzadas (esperas, highlight, scripts)
│ ├── questions/ # Validaciones y aserciones Screenplay
│ ├── task/ # Tareas reutilizables (Login, AddProduct, OpenWeb…)
│ └── ui/ # Page Objects y selectores
│
├── test/java/ # Step Definitions y Runners (opcional)
│
└── test/resources/
├── features/ # Escenarios en Gherkin
│ ├── login.feature
│ └── add_product.feature
└── serenity.conf # Configuración de Serenity, WebDriver y entornos


---

## 🧱 Arquitectura Técnica (Screenplay)

Este template utiliza **Screenplay Pattern**, el cual estructura la automatización en:

### 🔵 UI (Page Objects)
Selectores centralizados.  
Ejemplo:
```java
public class LoginPage {
    public static final Target USERNAME = Target.the("username field")
        .located(By.id("user-name"));
}

🟢 Tasks (acciones reutilizables)

Flujos de negocio.

public class Login implements Task { ... }

🟡 Interactions

Acciones técnicas (scroll, highlight, JS).

public class Highlight implements Interaction { ... }

🔴 Questions

Validaciones.

public class ValidText implements Question<Boolean> { ... }

⚙️ Configuración del Proyecto
Ejecutar pruebas
./gradlew clean test

Ejecutar solo un tag
./gradlew clean test -Dcucumber.filter.tags="@login"

Reportes Serenity

Luego de ejecutar, abrir:

target/site/serenity/index.html

🔧 Configurar la URL / entornos

Editar:

src/test/resources/serenity.conf


Ejemplo:

environments {
  default {
    base.url = "https://www.saucedemo.com"
  }
}

🧪 Feature Files incluidos
Login
Given que Andres abre la página de login
When ingresa credenciales válidas
Then debería ver la pantalla de productos

Add Product
Given que Andres está autenticado
When agrega un producto al carrito
Then debería ver el contador del carrito actualizado

🏗️ Cómo crear un nuevo módulo (recomendación profesional)

Crear PageObject en ui/

Crear Task para la acción principal

Crear Questions para validaciones

Crear Feature en features/

Crear StepDefinitions en test/java

Crear Runner (si deseas ejecución por módulo)

💡 Scripts útiles
gradlew clean test
gradlew test --info
gradlew dependencies

🧩 Requisitos

Java 11+

Gradle 7+

Chrome / Edge / Firefox

IntelliJ IDEA o VS Code

Git

🚀 CI/CD

Ejemplo GitHub Actions:

name: Serenity Tests
on: [push, pull_request]

jobs:
  run-tests:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v3
      - uses: actions/setup-java@v3
        with:
          java-version: '11'
          distribution: 'temurin'
      - run: ./gradlew clean test
      - uses: actions/upload-artifact@v3
        with:
          name: serenity-report
          path: target/site/serenity

👨‍💻 Autor

Andrés Felipe Contreras Muñoz
QA Automation Engineer
https://github.com/afecontre