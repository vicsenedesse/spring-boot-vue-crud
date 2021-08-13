module.exports = {
    devServer: {
      proxy: {
        '/api': {
          target: 'http://localhost:3000',
          changeOrigin: true
        }
      }
    }
  }

// const proxy = [
//     // {
//     //     context: '/api/',
//     //     target: 'http://localhost:8082',
//     //     pathRewrite: {'^/api/tutor' : ''}
//     // },
//     {
//         context: '/api',
//         target: 'http://localhost:8081',
//         pathRewrite: {'^/api/' : ''}
//     }
//   ];
// module.exports = proxy;