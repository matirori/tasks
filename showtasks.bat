call runcrud.bat
if "%ERRORLEVEL%" == "0" goto openbrowser
echo.
echo runcrud has errors -breaking work
goto fail

:openbrowser
cd C:\Program Files (x86)\Google\Chrome\Application\
start chrome.exe

if "%ERRORLEVEL%" == "0" goto openpage
echo.
echo runcrud has errors -breaking work
goto fail

:openpage
start http://localhost:8080/crud/v1/task/getTasks
goto end

:fail
echo.
echo There were errors.

:end
echo.
echo Work is finished.