FROM node:18
ENV NODE_ENV=productionn
WORKDIR /socket-chat
COPY . .

RUN yarn install --silent && yarn add env-cmd

EXPOSE 1300
CMD yarn start:production
