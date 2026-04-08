# Stage 1: Build React
FROM node:18-alpine AS build

WORKDIR /app

COPY package*.json ./
RUN npm install

COPY . .

RUN npm run build


# Stage 2: Chạy bằng nginx
FROM nginx:latest

COPY --from=build /app/build /usr/share/nginx/html

EXPOSE 80