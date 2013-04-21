require 'json'
require 'restclient'

vehicle = ARGV[0]
vehicle ||= 'VSTAR'
fillup = RestClient::Resource.new('http://localhost:8080/fillup')
response = fillup["vehicle/#{vehicle}"].get :accept => :json, :params => {:limit => 10}
json = JSON.parse(response.body)
puts JSON.pretty_generate(json)
