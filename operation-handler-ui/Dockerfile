FROM node:16.13.1-alpine

# set the working direction
WORKDIR /app

# install app dependencies
COPY package.json ./

COPY package-lock.json ./

RUN npm install

# add app
COPY . ./

EXPOSE 3000

# start app
CMD ["npm", "start"]