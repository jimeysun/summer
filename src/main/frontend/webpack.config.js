var path = require('path');
var webpack = require("webpack");

module.exports = {

    entry: [
        './client/main.jsx'
    ],

    devtool: "inline-source-map",

    output: {
        path: __dirname,
        filename: '../webapp/resources/bundle.js'
    },
    
    module: {
        loaders: [
            {
                test: path.join(__dirname, '.'),
                exclude: /(node_modules)/,
                loader: 'babel-loader',
                query: {
                    cacheDirectory: true,
                    presets: ['es2015', 'react']
                }
            },
            {  
                test: /\.jsx?$/,  
                exclude: /(node_modules|bower_components)/,  
                loader: 'babel-loader', // 'babel-loader' is also a legal name to reference  
                query: {  
                  presets: ['es2015', 'react'],
                  plugins: [["import", {libraryName: "antd", style: "css"}]]
                }  
            },  
            {
                test: /\.css$/,
                use: [
                    { loader: "style-loader" },
                    { loader: "css-loader" }
                ]
            },
            {
                test: /\.less/,
                loader: 'style-loader!css-loader!less-loader'
            },
            {
                test: /\.(png|jpg|gif)$/,
                loader: 'url-loader?limit=8192',
             }
        ]

    }

};