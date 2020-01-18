plugins {
    id("org.asciidoctor.jvm.pdf") version "2.4.0"
}

repositories {
    mavenCentral()
}

asciidoctorj {
    setJrubyVersion("9.1.17.0")
    setVersion("1.5.7")
    modules {
        diagram.version("1.5.9")
        pdf.version("1.5.0-alpha.17")
    }
}

tasks.asciidoctorPdf {
    sources {
        include("**/index.adoc")
    }
    resources {
        from(sourceDir) {
            include("**/images/**/*.jpg")
        }
    }
    attributes(mapOf(
        "outdir" to outputDir.absolutePath
    ))
    copyAllResources() // runs too late
}
