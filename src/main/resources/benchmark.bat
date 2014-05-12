@rem beta version, current version run error!
@rem Please give libraries path.
@set Libraries=%CD%/lib

@rem Please give JAVA_HOME location to run benchmark
<<<<<<< HEAD
@set JAVA_HOME=D:\Program Files\Java\jdk1.7.0_51
=======
@set JAVA_HOME=D:\Java\jdk1.7.0_51
>>>>>>> 0caa8a59e51a31331b0cd1b34494cc45231a819a

@set PATH=.;%JAVA_HOME%\bin;
@set CLASSPATH=%CD%;
@for /F "delims=" %%i in ('dir /A:-D /B /S "%Libraries%"') do @if exist %%i (
	@call :SetClassPath %%i
)
@set CLASSPATH=%CLASSPATH%;%JAVA_HOME%\lib\tools.jar
@set CLASSPATH=%CLASSPATH%;%JAVA_HOME%\lib\dt.jar
@set CLASSPATH=%CLASSPATH%;%JAVA_HOME%\jre\lib\rt.jar

@"%JAVA_HOME%\bin\java" org.boilit.ebm.Benchmark -config benchmark.properties -jdk "%JAVA_HOME%"

@pause 

@rem ========================SetClassPath Function============================
:SetClassPath
@set CLASSPATH=%CLASSPATH%;%1
@GOTO :EOF