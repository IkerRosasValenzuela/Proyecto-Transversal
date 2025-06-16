@echo off
title Compilar y ejecutar Registro Ambiental
setlocal

:: Ruta al archivo principal (ajusta si tu clase se llama diferente)
set MAINCLASS=Main
set JAR=sqlite-jdbc-3.36.0.3.jar

:: Verifica si existe al menos un .class más reciente que los .java
set NEED_COMPILE=0
for %%F in (*.java) do (
    if not exist "%%~nF.class" (
        set NEED_COMPILE=1
    ) else (
        for %%C in (%%~nF.class) do (
            for %%J in (%%F) do (
                if %%~tC LSS %%~tJ (
                    set NEED_COMPILE=1
                )
            )
        )
    )
)

if %NEED_COMPILE%==1 (
    echo  Compilando archivos .java...
    javac -encoding UTF-8 *.java
    if errorlevel 1 (
        echo  ERROR: La compilacion fallo. Revisa tu codigo.
        pause
        exit /b
    )
    echo  Compilacion exitosa.
) else (
    echo  Los archivos ya estaban compilados. Saltando compilacion.
)

echo  Ejecutando programa...
java -cp ".;%JAR%" %MAINCLASS%

pause
