FROM node:19.1.0-alpine
ADD ./src /app/books-service/src

WORKDIR /app

COPY package*.json /app/books-service/

RUN npm install /app/books-service/

CMD ["npm", "run", "dev"]