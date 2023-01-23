FROM node:19.1.0-alpine
WORKDIR /app

COPY package*.json ./
COPY ./src ./src

RUN [ "npm" , "ci" ]
CMD [ "npm" , "start" ]