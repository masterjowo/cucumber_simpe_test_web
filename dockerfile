FROM nginx
COPY target/cucumber-report/ /usr/share/nginx/html
EXPOSE 80
