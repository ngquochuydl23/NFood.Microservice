#See https://aka.ms/containerfastmode to understand how Visual Studio uses this Dockerfile to build your images for faster debugging.

FROM mcr.microsoft.com/dotnet/aspnet:7.0 AS base
WORKDIR /app
EXPOSE 80
EXPOSE 443

FROM mcr.microsoft.com/dotnet/sdk:7.0 AS build
WORKDIR /src
COPY ["NFood.FoodMenu.Service.csproj", "."]
RUN dotnet restore "./NFood.FoodMenu.Service.csproj"
COPY . .
WORKDIR "/src/."
RUN dotnet build "NFood.FoodMenu.Service.csproj" -c Release -o /app/build

FROM build AS publish
RUN dotnet publish "NFood.FoodMenu.Service.csproj" -c Release -o /app/publish /p:UseAppHost=false

FROM base AS final
WORKDIR /app
COPY --from=publish /app/publish .
ENTRYPOINT ["dotnet", "NFood.FoodMenu.Service.dll"]