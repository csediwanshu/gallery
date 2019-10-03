

const HOSTNAME: String = "localhost";
const PORT_NUMBER: number = 8080;
const APPLICATION_NAME: string =''
export const environment = {
  production: false,
  userAPIUrl: 'http://' +HOSTNAME +':' +PORT_NUMBER +APPLICATION_NAME +'/userAPI',
  addAlbumAPI: 'http://' +HOSTNAME +':' +PORT_NUMBER +APPLICATION_NAME +'/albumAPI',
  photoAPI: 'http://' +HOSTNAME +':' +PORT_NUMBER +APPLICATION_NAME +'/photoAPI'


};


