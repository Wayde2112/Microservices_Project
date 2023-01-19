FROM node:19.1.0-alpine
ADD ./src /app/book-service/src

WORKDIR /app

COPY package.json /app/book-service/
COPY package-lock.json /app/book-service/

RUN npm install /app/book-service/

CMD ["npm", "run dev"]